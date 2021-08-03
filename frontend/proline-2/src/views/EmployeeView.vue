<template>
  <CCard align="left">
    <CCardHeader id="header">
      <img src="../assets/icons/admin.jpg" hegiht="100" width="100" alt="img">
    </CCardHeader>
    <CCardBody id="body">
      <CRow>
        <CCol>
          <CCardText>
          <h1><span align="left" id="name">
            {{ item.name }}
          </span>
          <span align="left" id="surName">
            {{ item.surName }}
          </span></h1>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText align="left" id="role">
            <strong>{{item.role}}</strong>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText align="left" id="date">
            <strong>{{ item.date }}</strong>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText  id="bio">
            <h1 align="center"  id="blok">Biography</h1>
            <strong> {{ item.bio }} </strong>
          </CCardText>
        </CCol>
      </CRow>

      <CCRow>
        <CCol>
          <CCardText id="telephone">
            <p1>Telephone:</p1><strong> {{item.telephone}} </strong>
          </CCardText>
        </CCol>
      </CCRow>

      <CCRow>
        <CCol>
          <CCardText  id="mail">
            <p2>Mail:</p2><strong> {{item.mail}} </strong>
          </CCardText>
        </CCol>
      </CCRow>





    </CCardBody>
  </CCard>
</template>


<script>
import emp from "./_employee";
export default {
  name: "EmployeeView",
  props: ['itemx'],
  data () {
    return {
      item: emp[1]
    }
  }
}
</script>

<style scoped>

#name {
  font-family:"Arial";
  color:rgb(60,60,60);
}

#surName{
  font-family:"Arial";
  color:rgb(60,60,60);
}

#role{
  font-family:"Arial";
  color:rgb(60,60,60);
}

#date{
  font-family:"Arial";
  color:rgb(60,60,60);
}

#bio {
  overflow: scroll;
  font-family:"Arial";
  border-style: solid;
  box-sizing: content-box;
  padding:10px;
  height: 400px;
  text-overflow: ellipsis;
  margin-right:50px;
  margin-left:200px;
  text-overflow: ellipsis;
  overflow: scroll;
  color:rgb(60,60,60);
  border-radius: 8px;
  border-width: medium;
  border-color:teal;
background-color: lightcyan;

}

#telephone{
  font-family:"Arial";
  margin-right: 50px;
  margin-left:200px;
  box-sizing:content-box;
  height: 20px;
  color:rgb(60,60,60);
}

#mail{
  font-family:"Arial";
  margin-right: 50px;
  margin-left:200px;
  box-sizing:content-box;
  height: 20px;
  color:rgb(60,60,60);

}
#header
{
  background-color: teal;
}
#body
{
  background-color: lightblue;
}
#blok
{
  border-style: solid;
  border-radius: 20px;
  border-width: medium;


}
</style>