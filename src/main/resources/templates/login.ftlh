<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>Login page</div><br>
    <@l.login "/login" "Sign In"/>
    <a href="/registration">Add new user</a>
</@c.page>