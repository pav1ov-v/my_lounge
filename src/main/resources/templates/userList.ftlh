<#import "parts/common.ftlh" as c>

<@c.page>
    <div><a href="/home">Back home</a></div><br>
    <div>User list:</div>
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Role</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.getUsername()}</td>
                <td><#list user.getRoles() as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.getId()}">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>