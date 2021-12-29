<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <@l.logout/>
    </div>
    <div>
        <form method="post">
            <label>
                <input type="text" name="text" placeholder="Input message"/>
            </label>
            <label>
                <input type="text" name="tag" placeholder="Input tag">
            </label>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Add to list</button>
        </form>
    </div>
    <div>Sort by tag</div>
    <form method="post" action="filter">
        <label>
            <input type="text" name="filter" placeholder="Output tag">
        </label>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Search</button>
    </form>
    <div>Message list:</div>
    <#list messages as message>
        <div>
            <span>${message.text}</span>
            <i><${message.tag}></i>
            <strong>${message.getAuthorName()}</strong>
        </div>
    <#else>
        No message
    </#list>
</@c.page>