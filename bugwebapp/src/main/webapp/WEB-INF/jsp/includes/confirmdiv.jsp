<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String dialogId = request.getParameter("dialogId");
    String dialogContent = request.getParameter("dialogContent");
    String confirmBtnId = request.getParameter("confirmBtnId");
%>
<div class="modal fade" id="<%=dialogId==null?"confirmDialog":""%>" tabindex="-1" data-keyboard="false" aria-hidden="true" data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">确认</h4>
            </div>
            <div class="modal-body"><%=dialogContent == null ? "确认删除此项？" : dialogContent%></div>
            <div class="modal-footer">
                <button type="button" class="btn default" data-dismiss="modal">取消</button>
                <button type="button" class="btn blue" id="<%=confirmBtnId==null?"confirmBtn":confirmBtnId%>">确认</button>
            </div>
        </div>
    </div>
</div>