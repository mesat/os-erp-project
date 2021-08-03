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
            <h1 align="center"  id="blok"  >Biography</h1>
            <strong> {{ item.bio }} </strong>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText id="telephone">
            Telephone:<strong> {{item.telephone}} </strong>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText  id="mail">
            Mail:<strong> {{item.mail}} </strong>
          </CCardText>
        </CCol>
      </CRow>





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
      item: emp[this.$route.params.id]
    }
  }
}
</script>

<style scoped lang="scss">
$secondary-50:    #9da5b1;
$secondary:       #3c4b64;
#name {
  font-family:"Arial";
  color:rgb(60,60,60);
  font-size: 30px;
}

#surName{
  font-family:"Arial";
  color:rgb(60,60,60);
  font-size: 30px;
}

#role{
  font-family:"Arial";
  color:rgb(60,60,60);
  font-size: 25px;
}

#date{
  font-family:"Arial";
  color:rgb(60,60,60);
  font-size: 20px;
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
  border-width: large;
  border-color:#3c4b64;;
background-color: $secondary-50;

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
  background-color: #3c4b64;;
}
#body
{
  background-color: #9da5b1;
}
#blok
{
  border-style: solid;
  border-radius: 20px;
  border-width: medium;
  border-color: rgba(180, 180,180, 0.6);



}
</style>