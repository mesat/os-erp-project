<template>
  <CCard align="left">
    <CCardHeader>
      <img src="../assets/icons/admin.jpg" hegiht="100" width="100" alt="img">
    </CCardHeader>
    <CCardBody>
      <CRow>
        <CCol>
          <CCardText align="left">
            <h4>{{ item.name }}</h4>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText align="left">
            <strong>{{item.role}}</strong>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol>
          <CCardText align="left">
            <strong>{{ item.date }}</strong>
          </CCardText>
        </CCol>
      </CRow>

      <CRow>
        <CCol col="-12">
          <CCardText align="right" id="bio">
            <strong> {{ item.bio }} </strong>
          </CCardText>
        </CCol>
      </CRow>

      <CCRow>
        <CCol col="10">
          <CCardText align="right">
            <strong> {{item.iletisimBilgileri}} </strong>
          </CCardText>
        </CCol>
      </CCRow>

      <CCRow>
        <CCol col="10">
          <CCardText align="right">
            <strong> {{item.sosyalMedya}} </strong>
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
#bio {
border-style: solid;
  box-sizing: content-box;
  height: 400px;
 padding:10px;
  margin-right: 200px;
  margin-left: 200px;

}
</style>