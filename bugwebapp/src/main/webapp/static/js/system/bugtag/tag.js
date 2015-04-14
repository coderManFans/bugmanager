var tagList = function(){
    var tagTable;
    var $table = $("#datatable");
    var handleTagList = function(){
        tagTable = new Datatable();
        tagTable.init({
            src: $table,
            onQuery:function(data){
                data.tagName = $("#tagNameQuery").val();
            },
            onSortColumn:function(sortColumn,sortDirection){
                switch(sortColumn){
                    case "tagName":
                        sortColumn = "tag_name";
                        break;
                }
                return customGlobal.onSortColumnDefault(sortColumn,sortDirection);
            },
            dataTable:{
                "ajax":{
                    "url" : "tag/tagtype/getTagTypeListJson"
                },
                "column" : [
                    {data: 'tagName',orderable:true,searchable:true},
                    {data: 'operate',orderable:false,
                        render: function(data,type,full){
                            return '<a class="edit btn default btn-xs purple" paramName="' + full.tagName +'"><i class="fa fa-edit"></i>编辑</a>&nbsp;'
                                + '<a class="delete btn default btn-xs black" data-target="#confirmDialog" data-toggle="modal"><i class="fa fa-times"></i>删除</a>&nbsp;';
                        }
                    }

                ]
            }
        })
    }


    function validateError(regExp, target, message) {
        if (!new RegExp(regExp).test(target)) {
            toast.error(message);
            return false;
        } else {
            return true;
        }
    }

    var handleBugTag = {
        isEditable: true,
        showAddBugTagForm : function(){
            if(!handleBugTag.isEditable){
                toast.error("请完成当前编辑");
                return;
            }
            $("#addBugTagForm").show();
            handleBugTag.isEditable = false;
        },
        hideAddbugTag : function(){
            $("#addBugTagForm").hide();
            handleBugTag.isEditable = true;
        },
        addBugTag : function(){
            var data = {
                tagName : $("#addTagName").val()
            };
            if (!validateError("^[0-9a-zA-Z\_]+$", data.paramName, "变量名称名称的数据只能包括字母数字下划线")) {
                return;
            }
            $.ajax({
                url : "tag/tagtype/add",
                data : JSON.stringify(data),
                type : "json",
                contentType : "application/json; charset=utf-8",
                success : function(data){
                    if(customGlobal.ajaxCallback(data)){
                        tagTable.reload(false);
                        handleBugTag.isEditable = true;
                    }
                }
            })
        }
    }

    var handleEvent = function(){
        $("#addBugTagForm").on("click",handleBugTag.showAddBugTagForm)
    }

    return {
        init : function(){
            handleTagList();
            handleEvent();
        }
    }
}