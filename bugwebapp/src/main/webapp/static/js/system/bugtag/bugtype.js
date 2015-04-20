/**
 * Created by fcs on 2015/4/20.
 */
var bugListTable = function(){
    var bugTypeTable;
    var $table = $("#datatable");
    var handlebugTableEvent = function(){
        bugTypeTable = new Datatable();
        bugTypeTable.init({
                src: $table,
                onQuery: function(data){
                    data.bugType = $("#bugTypeQuery").val();
                    data.bugintroduce = $("#bugTypeIntroduceQuery").val();
                },
                onSortColumn: function(sortColumn,sortDirection){
                    switch (sortColumn){
                        case "bugTypeId":
                            sortColumn = "bug_typeid";
                            break;
                        case "bugType":
                            sortColumn = "bug_type";
                        break;
                        case "bugintroduce":
                            sortColumn = "bug_introduce";
                        break;
                    }
                    return customGlobal.onSortColumnDefault(sortColumn,sortDirection);
                },

                datatable:{
                    "ajax": {
                        "url" : "tags/bugtype/getBugTypeListPage"     //ajax resource
                    },
                    column: [
                        {data: 'bugTypeId', orderable: true, searchable: true},
                        {data: 'bugType', orderable: true, searchable: true},
                        {data: 'bugintroduce', orderable: true, searchable: true},
                        {data: 'operate', orderable: false,
                            render: function (data, type, full) {
                                return '<a class="edit btn default btn-xs purple"'+'" bugType="' + full.bugType +'" bugintroduce="' + full.bugintroduce +'"><i class="fa fa-edit"></i>编辑</a>&nbsp;'
                                    + '<a class="delete btn default btn-xs black" data-target="#confirmDialog" data-toggle="modal"><i class="fa fa-times"></i>删除</a>&nbsp;';
                            }
                        }
                    ]
                }
            }
        );
    };

    function validateError(regExp, target, message) {
        if (!new RegExp(regExp).test(target)) {
            toast.error(message);
            return false;
        } else {
            return true;
        }
    }

    var handleBugTypeEvent = {
        isEditable: true,
        showAddBugType: function () {
            if (!handleBugTypeEvent.isEditable) {
                alert(handleBugTypeEvent.isEditable);
                console.log(handleBugTypeEvent.isEditable);
                toast.error("请添加完当前添加项");
                return;
            }

            $("#addbugTypeForm").show();
            handleBugTypeEvent.isEditable = false;
        },

        hideaddbugType: function () {
            $("#addbugTypeForm").hide();
            handleBugTypeEvent.isEditable = true;
        },

        addbugType: function () {
            var data = {
                bugType: $("#addbugTypeName").val()
            };
            if (!validateError("^[0-9a-zA-Z\_]+$", data.bugType, "错误名称的数据只能包括字母数字下划线")) {
                return;
            }
            $.ajax({
                url: "tags/bugtype/add",
                type: "post",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (customGlobal.ajaxCallback(data)) {
                        bugTypeTable.reloadTable(false);
                        $("#addbugTypeForm").hide();
                        handleBugTypeEvent.isEditable = true;
                        $("#addbugTypeName").val("");
                        $("#addBugTypeIntroduce").val("");
                    }
                }
            });
        },

        deletebugType: function (table) {
            var $this = table;
            $("#confirmBtn").off("click.deleteRow").on("click.deleteRow", function () {
                $.ajax({
                    url: "tags/bugtype/" + $table.DataTable().row($this.parents('tr')[0]).data().tagId,
                    dataType: "json",
                    type: "DELETE",
                    success: function (data) {
                        $("#confirmDialog").modal("hide");
                        if (customGlobal.ajaxCallback(data)) {
                            bugTypeTable.reloadTable(false);
                        }
                    }
                })
            })
        },

        showInput: function (table) {
            if (handleBugTypeEvent.isEditable == false) {
                toast.error("请完成当前编辑");
            }
            else {
                var nRow = table.parents('tr')[0];
                var tag = $table.DataTable().row(nRow).data();
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" id="updatebugTypeId" class="form-control input-sm" readonly="true" value="' + tag.bugTypeId + '">';
                jqTds[1].innerHTML = '<input type="text" id="updatebugTypeName" class="form-control input-sm"  value="' + tag.bugType + '">';
                jqTds[2].innerHTML = '<input type="text" id="updatebugintroduce" class="form-control input-sm"  value="' + tag.bugType + '">';

                jqTds[3].innerHTML = '<a class="update btn default btn-xs blue" href="javascript:;"><i class="fa fa-edit"></i>保存</a>&nbsp;' +
                '<a class="cancel btn default btn-xs" href="javascript:;"><i class="fa fa-times"></i>取消</a>';
                handleBugTypeEvent.isEditable = false;
            }
        },

        hideInput: function () {
            $table.reloadTable(false);
            handleBugTypeEvent.isEditable = true;
        },

        updatebugType: function () {
            var data = {
                bugTypeId: $("#updatebugTypeId").val(),
                bugType: $("#updatebugTypeName").val(),
                bugintroduce: $("#updatebugintroduce").val()

            };
            $.ajax({
                url:  "tags/bugtype",
                dataType: "json",
                type: "PUT",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (customGlobal.ajaxCallback(data)) {
                        bugTypeTable.reloadTable(true);
                        handleBugTypeEvent.isEditable = true;
                    }
                }
            });
        }
    };

    var handleEvent = function () {
        $("#showAddBugType").on("click", handleBugTypeEvent.showAddBugType);
        $("#addbugTypeButton").live("click", handleBugTypeEvent.addbugType);
        $("#cancelAdd").live("click", handleBugTypeEvent.hideaddbugType);
        $table.on("click", "a.delete", function () {
            handleBugTypeEvent.deletebugType($(this));
        });
        $table.on("click", "a.edit", function () {
            handleBugTypeEvent.showInput($(this));
        });
        $table.on("click", "a.update", handleBugTypeEvent.updatebugType);
        $table.on("click", "a.cancel", handleBugTypeEvent.hideInput);
    };

    return {
        init:function(){
            handleEvent();
            handlebugTableEvent();
        }
    }

}();