<template>
  <CCard align="left">
    <CCardHeader id="header">
      <img src="../assets/icons/admin.jpg" height="100" width="100" alt="img"/>
    </CCardHeader>
    <CCardBody id="body">
      <CRow>
        <CCol>
          <CCardText>
          <span id="name">
            {{ item.name }}
          </span>
          <span id="surName">
            {{ item.surName }}
          </span>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText align="left" id="role">
            <span>{{item.role}}</span>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText align="left" id="date">
            <span>{{ item.date }}</span>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText  id="bio">
            <h1 id="blok"  >Biography</h1>
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
      item: emp[0]
    }
  }
}
</script>

<style scoped lang="scss">
$secondary-50:    #9da5b1;
$secondary:       #3c4b64;
#name {
  color:rgb(60,60,60);
  font-size: 25px;
}

#surName{
  color:rgb(60,60,60);
  font-size: 25px;
}

#role{
  font-family:"Brush Script MT";
  color:rgb(60,60,60);
  font-size: 25px;

}

#date{
  color:rgb(60,60,60);
  font-size: 15px;
  margin-top: 5px;
}

#bio {
  overflow: scroll;
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
  border-color:#3c4b64;;
  background-color: #b1b7c1;
  margin-bottom: 20px;

}

#telephone{
  margin-right: 50px;
  margin-left:200px;
  box-sizing:content-box;
  height: 20px;
  color:rgb(60,60,60);
  font-size: 16px;
  margin-bottom: 10px;
}

#mail{
  margin-right: 50px;
  margin-left:200px;
  box-sizing:content-box;
  height: 20px;
  color:rgb(60,60,60);
  font-size: 16px;

}
#header
{
  background-color: #3c4b64;;
}
#body
{
  background-color: #b1b7c1;
}
#blok
{
  border-style: solid;
  border-radius: 20px;
  border-width: medium;
  border-color: rgba(150, 150,150, 0.6);
  text-align: center;



}
</style>