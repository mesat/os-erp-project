<template>
  <CCard align="left">
    <CCardHeader id="header">
      <img src="../assets/icons/admin.jpg" height="100" width="100" alt="img"/>
      <span id="name">
            {{ item.name }}
          </span>
      <span id="surName">
            {{ item.surName }}
          </span>
    </CCardHeader>
    <CCardBody id="body">

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
            Start Date <strong>{{ item.date }}</strong>
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

      <CDataTable :fields="fields">




      </CDataTable>



    </CCardBody>
  </CCard>
</template>


<script>
import emp from "./_employee";

const fields = [{
  key: "icon",
  label: "",
  _classes: "col-xs-1"
}, {
  key: "name",
  label: "Name",
  _classes: "col-sm-2"
}, {
  key: "nick",
  label: "Nick",
  _classes: "col-sm-2"
}, {
  key: "link",
  label: "Link",
  _classes: "col-xl-7"
}, {
  key: "delete",
  label: '',
  _classes: "col-xs-1"
}]

export default {
  name: "EmployeeView",
  props: ['itemx'],
  data () {
    return {
      item: emp[this.$route.params.id],
      fields: fields
    }
  }
}
</script>

<style scoped lang="scss">
$secondary-50:    #9da5b1;
$secondary:       #3c4b64;
#name {
  color:rgb(255,255,255);
  font-size: 45px;
}

#surName{
  color:rgb(255,255,255);
  font-size: 45px;
}

#role{
  font-family:"Berlin Sans FB";
  color:rgb(60,60,60);
  font-size: 35px;

}

#date{
  color:rgb(60,60,60);
  font-size: 15px;
  margin-top: 5px;
}

#bio {
  border-style: solid;
  box-sizing: content-box;
  padding: 10px;
  height: 400px;
  text-overflow: ellipsis;
  margin-right: 50px;
  margin-left: 200px;
  text-overflow: ellipsis;
  color: rgb(60, 60, 60);
  border-radius: 8px;
  border-width: medium;
  border-color: #3c4b64;;
  background-color: #b1b7c1;
  margin-bottom: 20px;
  overflow: auto;

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
  margin-bottom: 15px;

}
#header
{
  background-color: #3c4b64;

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
  font-family:"Arial Rounded MT Bold";


}



</style>