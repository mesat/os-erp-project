<template>
  <CCard align="left">
    <CCardHeader>
      <img src="../assets/icons/admin.jpg" hegiht="100" width="100" alt="img">
    </CCardHeader>
    <CCardBody>
      <CRow>
        <CCol>
          <CCardText align="left" id="name">
            <h4>{{ item.name }}</h4>
          </CCardText>
        </CCol>
        <CCol>
          <CCardText align="left" id="surName">
            <h4>{{ item.surName }}</h4>
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
          <CCardText align="right" id="bio">
            <strong> {{ item.bio }} </strong>
          </CCardText>
        </CCol>
      </CRow>

      <CCRow>
        <CCol>
          <CCardText align="right" id="telephone">
            <strong> {{item.telephone}} </strong>
          </CCardText>
        </CCol>
      </CCRow>

      <CCRow>
        <CCol>
          <CCardText align="right" id="mail">
            <strong> {{item.mail}} </strong>
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
      item: {...emp}
    }
  }
}
</script>

<style scoped>

#name {
  color:Gray;
}

#surName{
  color:Gray;
}

#role{
  color:Gray;
}

#date{
  color:Gray;
}

#bio {
border-style: solid;
  box-sizing: content-box;
  padding:10px;
  height: 400px;
  margin-right:50px;
  margin-left:200px;
  text-overflow: ellipsis;
  overflow: hidden;

}

#telephone{
  margin-right: 50px;
  box-sizing:content-box;
  height: 20px;
}

#mail{
  margin-right: 50px;
  box-sizing:content-box;
  height: 20px;

}
</style>