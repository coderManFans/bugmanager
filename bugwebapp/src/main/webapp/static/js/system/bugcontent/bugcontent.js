/**
 * Created by fcs on 2015/3/30.
 */
var bugContentListTable = function () {
    var bugcontentTable;
    var $table = $("#dataTable");
    var handleRecords = function () {
        bugcontentTable = new Datatable();
        bugcontentTable.init({
            src: $table,
            onQuery: function (data) {
                data.bugReason = $("#bugReasonQuery").val();
            },
            onSortColumn: function (sortColumn, sortDirection) {
                switch (sortColumn) {
                    case "bugcontentid":
                        sortColumn = "bug_contentid";
                        break;
                    case "bugReason":
                        sortColumn = "bug_reason";
                        break;
                    case "hasSolved":
                        sortColumn = "has_sovled";
                    case "upDate":
                        sortColumn = "add_date";
                    case "userId":
                        sortColumn = "user_id";
                }
                return customGlobal.onSortColumnDefault(sortColumn, sortDirection);
            },

            dataTable: {
                "ajax": {
                    "url": "buginfo/bugcontent/getBugcontentListPage" // ajax source
                },
                "columns": [
                    {data: 'bugcontentid', orderable: true, searchable: true},
                    {data: 'bugReason', orderable: true, searchable: true},
                    {data: 'hasSolved', orderable: true, searchable: false},
                    {data: 'upDate', orderable: true, searchable: false},
                    {data: 'userId', orderable: true, searchable: false},
                    {data: 'operate', orderable: false,
                        render: function (data, type, full) {
                            return '<a class="edit btn default btn-xs purple" bugcontentid="' + full.bugcontentid +  '" bugReason="'+full.bugReason+'" hasSolved="'+full.hasSolved+'" upDate="'+full.upDate+'"><i class="fa fa-edit"></i>编辑</a>&nbsp;'
                                + '<a class="delete btn default btn-xs black" data-target="#confirmDialog" data-toggle="modal"><i class="fa fa-times"></i>删除</a>&nbsp;';
                        }
                    }
                ]
            }
        });
    };

    function validateError(regExp, target, message) {
        if (!new RegExp(regExp).test(target)) {
            toast.error(message);
            return false;
        } else {
            return true;
        }
    }

    var handlebugcontentEvent = {
        isEditable: true,
        deletebugcontent: function (table) {
            var $this = table;
            $("#confirmBtn").off("click.deleteRow").on("click.deleteRow", function () {
                $.ajax({
                    url: "buginfo/bugcontent/"+$table.DataTable().row($this.parents('tr')[0]).data().bugcontentid,
                    dataType: "json",
                   // data: JSON.stringify($table.DataTable().row($this.parents('tr')[0]).data().bugcontentid),
                    type: "DELETE",
                    success: function (data) {
                        $("#confirmDialog").modal("hide");
                        if (customGlobal.ajaxCallback(data)) {
                            bugcontentTable.reloadTable(false);
                        }
                    }
                })
            })
        },

        showInput: function (table) {
            if (handlebugcontentEvent.isEditable == false) {
                toast.error("请完成当前编辑");
            }
            else {
                var nRow = table.parents('tr')[0];
                var bugcontent = $table.DataTable().row(nRow).data();
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" id="updatebugcontentId" class="form-control input-sm" readonly="true" value="' + bugcontent.bugcontentid + '">';
                jqTds[1].innerHTML = '<input type="text" id="updatebugReasonid" class="form-control input-sm"  value="' + bugcontent.bugReason + '">';
                jqTds[2].innerHTML = '<input type="radio" id="updateHasSolvedid" name="hasSolved" checked="checked" class="form-control input-sm"  value="' + bugcontent.hasSolved + '"></b>'+
                     bugcontent.hasSolved+ '<input type="radio" id="updateHasSolvedid"  name="hasSolved" class="form-control input-sm"  value="' +  !bugcontent.hasSolved  + '">'+!bugcontent.hasSolved;
                jqTds[3].innerHTML = '<input type="text" id="updateUpDateid" class="form-control input-sm"  value="' + bugcontent.upDate + '">';
                jqTds[4].innerHTML = '<input type="text" id="updateUserId" readonly="true" class="form-control input-sm"  value="' + bugcontent.userId + '">';
                jqTds[5].innerHTML = '<a class="update btn default btn-xs blue" href="javascript:;"><i class="fa fa-edit"></i>保存</a>&nbsp;' +
                '<a class="cancel btn default btn-xs" href="javascript:;"><i class="fa fa-times"></i>取消</a>';
                handlebugcontentEvent.isEditable = false;
            }
        },

        hideInput: function () {
            bugcontentTable.reloadTable(false);
            handlebugcontentEvent.isEditable = true;
        },

        updatebugcontent: function () {
            alert($("#updateHasSolvedid").val()+"-------");
            var data = {
                bugcontentid: $("#updatebugcontentId").val(),
                hasSovled: $("#updateHasSolvedid").val(),
                upDate: $("#updateUpDateid").val(),
                bugReason: $("#updatebugReasonid").val()
            };
            $.ajax({
                url:  "buginfo/bugcontent/update",
                dataType: "json",
                type: "PUT",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (customGlobal.ajaxCallback(data)) {
                        alert(data+"----------------");
                        bugcontentTable.reloadTable(true);
                        handlebugcontentEvent.isEditable = true;
                    }
                }
            });
        }
    };

    var handleEvent = function () {
        $table.on("click", "a.delete", function () {
            handlebugcontentEvent.deletebugcontent($(this));
        });
        $table.on("click", "a.edit", function () {
            handlebugcontentEvent.showInput($(this));
        });
        $table.on("click", "a.update", handlebugcontentEvent.updatebugcontent);
        $table.on("click", "a.cancel", handlebugcontentEvent.hideInput);
    };

    return {
        init: function () {
            handleRecords();
            handleEvent();
        }
    };
}();