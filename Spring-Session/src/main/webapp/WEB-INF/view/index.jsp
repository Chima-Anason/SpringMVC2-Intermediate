<h1 align="center">Session attributes examples</h1>

First Name : ${firstName} 
</br>
Last Name : ${lastName}
</br>
Address : ${address}
</br>
<hr/>
</br>


First Name Value Fetching From The Request : ${requestScope.firstName}

</br>

First Name Value Fetching From The Session : ${sessionScope.firstName}
</br>
<a href="/Spring-Session/${next}">Next ${next}</a>