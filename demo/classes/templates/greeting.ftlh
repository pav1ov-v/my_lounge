<#import "parts/common.ftlh" as c>

<@c.page>
    <div>Hello, ${user.getUsername()}!</div><br>
    <a href="/home">Home page</a>
</@c.page>