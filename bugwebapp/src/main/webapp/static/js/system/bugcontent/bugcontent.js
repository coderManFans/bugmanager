/**
 * Created by fcs on 2015/3/30.
 */

var bugtagList = function(){
     var basePath = "http://localhost:8089/bugweb";
    /**
     * 请求tagtype，返回数据
     */
    var handleBugTag = function(){
        $.ajax({
            async:false,      //默认为true,改为false，则为同步请求，可以保证，同时进行如下两个请求，前面一个不会被后面的覆盖掉
            url: basePath+"/tag/tagtype/getTagTypeListJson",
            type: "get",
            timeout:2000,
            dataType: 'json',
            error: erroryFunction,
            success: successFunction
        })
        function erroryFunction(){
            alert("数据加载tagtypeList失败，请检查传输格式等");
        }
        function successFunction(responseData){
            var json = eval(responseData);
            alert("bugType"+"---"+json);
            $.each(json,function(bugTypeId,bugType){
                if(bugTypeId == "1" || bugTypeId == "2"){
                    $("#bugTypeSelect").append("<option value="+bugTypeId+">"+bugType+"</option>").attr("selected",true);;
                }else{
                    $("#bugTypeSelect").append("<option value="+bugTypeId+">"+bugType+"</option>");
                }
            });
        }
    };


    /**
     * 请求bugtype，返回数据
     * medium
     */
    var handleBugType = function (){
        $.ajax({
            async:false,      //默认为true,改为false，则为同步请求
            url: basePath+"/tag/bugtype/getBugTypeListJson",
            type: "get",
            timeout:2000,
            dataType: 'json',
            error: erroryFunction,
            success:successFunction
        })
        function erroryFunction(){
            alert("加载数据bugTypeList失败，请检查传输格式等");
        }
        function successFunction(responseData){
            var json = eval(responseData);
            function successFunction(responseData){
                var json = eval(responseData);
                alert("tagType"+"---"+json);
                $.each(json,function(tagId,tagName){
                    if(tagId == "1" || tagId == "2"){
                        $("#bugTypeSelect").append("<option value="+tagId+">"+tagName+"</option>").attr("selected",true);
                    }else{
                        $("#bugTypeSelect").append("<option value="+tagId+">"+tagName+"</option>");
                    }
                });
            }
        }
    };

    return {
        init:function(){
            handleBugTag();
            handleBugType();
        }
    };
}();
