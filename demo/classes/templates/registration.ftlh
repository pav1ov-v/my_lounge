<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>Add new user</div><br>
    ${message!""}
    <@l.login "/registration" "Add"/>
    <a href="/login">Back to login</a>
</@c.page>