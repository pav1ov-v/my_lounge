<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout/>
        <span><a href="/user">User list</a></span>
    </div><br>
    <div>Add message to list</div>
    <div>
        <form method="post">
            <label><input type="text" name="text" placeholder="Input message"/></label>
            <label><input type="text" name="tag" placeholder="Input tag"></label>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Add</button>
        </form>
    </div>
    <div>Search by tag</div>
    <form method="get" action="/home">
        <label><input type="text" name="filter" value="${filter!""}" placeholder="Output tag"></label>
        <button type="submit">Search</button>
    </form>
    <div>Message list:</div>
    <#list messages as message>
        <div>
            <span>${message.getText()}</span>
            <i><${message.getTag()}></i>
            <strong>${message.getAuthorName()}</strong>
        </div>
    <#else>
        No message
    </#list>
</@c.page>