/**
 * Created by fcs on 2015/3/29.
 */
var submit = function(){
    var submittag = $("#btnsubmit").("onclick",function(){
        var is = $("#tagName").val();
        alert(is);
        $.ajax({
            url: "/tag/tagtype",
            type: "post",
            dataType:"json",
            data:JSON.stringify({
                tagName: $("#tagName").val()
            }),
            success:function(data){
                alert(data.tagName);
            },
            error:function(e){
                allert("err: "+e);
            }
        })
    })
    return {
        init: function () {
            submittag();
        }
    };
}();