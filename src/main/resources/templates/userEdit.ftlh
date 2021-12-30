<#import "parts/common.ftlh" as c>

<@c.page>
    <div><a href="/user">Back to user list</a> </div><br>
    <div>User editor</div><br>
    <div>Edit username</div>
    <form action="/user" method="post">
        <div><label><input type="text" name="username" value="${user.getUsername()}"></label></div><br>
        <div>Edit user role</div>
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox"
                           name="${role}" ${user.getRoles()?seq_contains(role)?string("checked", "")}>${role}
                </label>
            </div>
        </#list><br>
        <input type="hidden" name="userId" value="${user.getId()}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Save changes</button>
    </form>
</@c.page>