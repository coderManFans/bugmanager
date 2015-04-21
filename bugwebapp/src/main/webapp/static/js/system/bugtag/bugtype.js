var bugListTable = function () {
    var globalTable;
    var $table = $("#dataTable");
    var handleRecords = function () {
        globalTable = new Datatable();
        globalTable.init({
            src: $table,
            onQuery: function (data) {
                data.bugType = $("#bugTypeQuery").val();
                data.bugintroduce = $("#bugTypeIntroduceQuery").val();
            },
            onSortColumn: function (sortColumn, sortDirection) {
                switch (sortColumn) {
                    case "bugTypeId":
                        sortColumn = "bug_typeid";
                        break;
                    case "bugType":
                        sortColumn = "bug_type";
                        break;
                    case "bugintroduce":
                        sortColumn = "bugintroduce";
                        break;
                }
                return customGlobal.onSortColumnDefault(sortColumn, sortDirection);
            },
            dataTable: {
                "ajax": {
                    "url": "tags/bugtype/getBugTypeListPage" // ajax source
                },
                "columns": [
                    {data: 'bugTypeId', orderable: true, searchable: true},
                    {data: 'bugType', orderable: true, searchable: true},
                    {data: 'bugintroduce', orderable: true, searchable: true},
                    {data: 'operate', orderable: false,
                        render: function (data, type, full) {
                            return '<a class="edit btn default btn-xs purple" bugType="' + full.bugType +  '" bugintroduce="'+full.bugintroduce+'"><i class="fa fa-edit"></i>编辑</a>&nbsp;'
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

    var handlebugTypeEvent = {
        isEditable: true,
        showAddbugType: function () {
            if (!handlebugTypeEvent.isEditable) {
                toast.error("请添加完当前添加项");
                return;
            }

            $("#addbugTypeForm").show();
            handlebugTypeEvent.isEditable = false;
        },
        hideAddbugType: function () {
            $("#addbugTypeForm").hide();
            handlebugTypeEvent.isEditable = true;
        },
        addbugType: function () {
            var data = {
                paramName: $("#addParamName").val(),
                paramValue: $("#addParamValue").val(),
                paramDescription: $("#addParamDescription").val()
            };
            if (!validateError("^[0-9a-zA-Z\_]+$", data.paramName, "变量名称名称的数据只能包括字母数字下划线")) {
                return;
            }
            $.ajax({
                url: "system/bugType",
                type: "post",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (customGlobal.ajaxCallback(data)) {
                        globalTable.reloadTable(false);
                        $("#addbugTypeForm").hide();
                        handlebugTypeEvent.isEditable = true;
                        $("#addBugTypeName").val("");
                        $("#addBugTypeIntroduce").val("");
                    }
                }
            });
        },
        deletebugType: function (table) {
            var $this = table;
            $("#confirmBtn").off("click.deleteRow").on("click.deleteRow", function () {
                $.ajax({
                    url: "tags/bugtype/" + $table.DataTable().row($this.parents('tr')[0]).data().bugTypeId,
                    dataType: "json",
                    type: "DELETE",
                    success: function (data) {
                        $("#confirmDialog").modal("hide");
                        if (customGlobal.ajaxCallback(data)) {
                            globalTable.reloadTable(false);
                        }
                    }
                })
            })
        },
        showInput: function (table) {
            if (handlebugTypeEvent.isEditable == false) {
                toast.error("请完成当前编辑");
            }
            else {
                var nRow = table.parents('tr')[0];
                var bugType = $table.DataTable().row(nRow).data();
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" id="updateBugTypeId" class="form-control input-sm" readonly="true" value="' + bugType.bugTypeId + '">';
                jqTds[1].innerHTML = '<input type="text" id="updateBugType" class="form-control input-sm" value="' + bugType.bugType + '">';
                jqTds[2].innerHTML = '<input type="text" id="updateBugintroduce" class="form-control input-sm" value="' + bugType.bugintroduce + '">';
                jqTds[3].innerHTML = '<a class="update btn default btn-xs blue" href="javascript:;"><i class="fa fa-edit"></i>保存</a>&nbsp;' +
                '<a class="cancel btn default btn-xs" href="javascript:;"><i class="fa fa-times"></i>取消</a>';
                handlebugTypeEvent.isEditable = false;
            }
        },
        hideInput: function () {
            globalTable.reloadTable(false);
            handlebugTypeEvent.isEditable = true;
        },

        updatebugType: function () {
            var data = {
                bugTypeId: $("#updateBugTypeId").val(),
                bugType: $("#updateBugType").val(),
                bugintroduce: $("#updateBugintroduce").val()
            };
            $.ajax({
                url:  "tags/bugtype",
                dataType: "json",
                type: "PUT",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (customGlobal.ajaxCallback(data)) {
                        globalTable.reloadTable(true);
                        handlebugTypeEvent.isEditable = true;
                    }
                }
            });
        }
    };

    var handleEvent = function () {
        $("#showAddbugType").on("click", handlebugTypeEvent.showAddbugType);
        $("#addbugTypeButton").live("click", handlebugTypeEvent.addbugType);
        $("#cancelAdd").live("click", handlebugTypeEvent.hideAddbugType);
        $table.on("click", "a.delete", function () {
            handlebugTypeEvent.deletebugType($(this));
        });
        $table.on("click", "a.edit", function () {
            handlebugTypeEvent.showInput($(this));
        });
        $table.on("click", "a.update", handlebugTypeEvent.updatebugType);
        $table.on("click", "a.cancel", handlebugTypeEvent.hideInput);
    };

    return {
        init: function () {
            handleRecords();
            handleEvent();
        }
    };
}();