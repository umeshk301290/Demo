<html>
<body>
<#list index as i>
    <tr>demo name
    <#list i.listJam as item>
       <td>
       ${item.home}
       </td>
       <h>java</h>
       <td>
       ${item.no}
       </td>
       </tr>
    </#list> 
</#list>
</body>
</html>
