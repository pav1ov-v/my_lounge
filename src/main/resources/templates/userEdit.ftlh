<#import "parts/common.ftlh" as c>

<@c.page>
    User editor
    <form action="/user" method="post">
        <label><input type="text" name="username" value="${user.getUsername()}"></label>
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox"
                           name="${role}" ${user.getRoles()?seq_contains(role)?string("checked", "")}>${role}
                </label>
            </div>
        </#list>
        <input type="hidden" name="userId" value="${user.getId()}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Save changes</button>
    </form>
</@c.page>