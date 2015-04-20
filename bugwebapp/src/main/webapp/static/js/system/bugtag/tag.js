var tagListTable = function () {
    var tagTable;
    var $table = $("#dataTable");
    var handleRecords = function () {
        tagTable = new Datatable();
        tagTable.init({
            src: $table,
            onQuery: function (data) {
                data.tagName = $("#tagNameQuery").val();
            },

            onSortColumn: function (sortColumn, sortDirection) {
                switch (sortColumn) {
                    case "tagId":
                        sortColumn = "tag_id";
                        break;
                    case "tagName":
                        sortColumn = "tag_name";
                        break;
                }
                return customGlobal.onSortColumnDefault(sortColumn, sortDirection);
            },

            dataTable: {
                "ajax": {
                    "url": "tags/tagtype/getTagTypeListPage" // ajax source
                },
                "columns": [
                    {data: 'tagId', orderable: true, searchable: true},
                    {data: 'tagName', orderable: true, searchable: true},
                    {data: 'operate', orderable: false,
                        render: function (data, type, full) {
                            return '<a class="edit btn default btn-xs purple"'+'" tagName="' + full.tagName +'"><i class="fa fa-edit"></i>编辑</a>&nbsp;'
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

    var handletagEvent = {
        isEditable: true,
        showAddtag: function () {
            if (!handletagEvent.isEditable) {
                alert(handletagEvent.isEditable);
                console.log(handletagEvent.isEditable);
                toast.error("请添加完当前添加项");
                return;
            }

            $("#addtagForm").show();
            handletagEvent.isEditable = false;
        },

        hideAddtag: function () {
            $("#addtagForm").hide();
            handletagEvent.isEditable = true;
        },

        addtag: function () {
            var data = {
                tagName: $("#addTagName").val()
            };
            if (!validateError("^[0-9a-zA-Z\_]+$", data.tagName, "变量名称名称的数据只能包括字母数字下划线")) {
                return;
            }
            $.ajax({
                url: "tags/tagtype/add",
                type: "post",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (customGlobal.ajaxCallback(data)) {
                        tagTable.reloadTable(false);
                        $("#addtagForm").hide();
                        handletagEvent.isEditable = true;
                        $("#addTagName").val("");
                    }
                }
            });
        },

        deletetag: function (table) {
            var $this = table;
            $("#confirmBtn").off("click.deleteRow").on("click.deleteRow", function () {
                $.ajax({
                    url: "tags/tagtype/" + $table.DataTable().row($this.parents('tr')[0]).data().tagId,
                    dataType: "json",
                    type: "DELETE",
                    success: function (data) {
                        $("#confirmDialog").modal("hide");
                        if (customGlobal.ajaxCallback(data)) {
                            tagTable.reloadTable(false);
                        }
                    }
                })
            })
        },

        showInput: function (table) {
            if (handletagEvent.isEditable == false) {
                toast.error("请完成当前编辑");
            }
            else {
                var nRow = table.parents('tr')[0];
                var tag = $table.DataTable().row(nRow).data();
                var jqTds = $('>td', nRow);
                jqTds[0].innerHTML = '<input type="text" id="updateTagId" class="form-control input-sm" readonly="true" value="' + tag.tagId + '">';
                jqTds[1].innerHTML = '<input type="text" id="updateTagName" class="form-control input-sm"  value="' + tag.tagName + '">';
                jqTds[2].innerHTML = '<a class="update btn default btn-xs blue" href="javascript:;"><i class="fa fa-edit"></i>保存</a>&nbsp;' +
                '<a class="cancel btn default btn-xs" href="javascript:;"><i class="fa fa-times"></i>取消</a>';
                handletagEvent.isEditable = false;
            }
        },

        hideInput: function () {
            tagTable.reloadTable(false);
            handletagEvent.isEditable = true;
        },

        updatetag: function () {
            var data = {
                tagId: $("#updateTagId").val(),
                tagName: $("#updateTagName").val()
            };
            $.ajax({
                url:  "tags/tagtype",
                dataType: "json",
                type: "PUT",
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    if (customGlobal.ajaxCallback(data)) {
                        tagTable.reloadTable(true);
                        handletagEvent.isEditable = true;
                    }
                }
            });
        }
    };

    var handleEvent = function () {
        $("#showAddtag").on("click", handletagEvent.showAddtag);
        $("#addtagButton").live("click", handletagEvent.addtag);
        $("#cancelAdd").live("click", handletagEvent.hideAddtag);
        $table.on("click", "a.delete", function () {
            handletagEvent.deletetag($(this));
        });
        $table.on("click", "a.edit", function () {
            handletagEvent.showInput($(this));
        });
        $table.on("click", "a.update", handletagEvent.updatetag);
        $table.on("click", "a.cancel", handletagEvent.hideInput);
    };

    return {
        init: function () {
            handleRecords();
            handleEvent();
        }
    };
}();