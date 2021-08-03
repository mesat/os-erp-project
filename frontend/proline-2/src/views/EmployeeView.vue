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
        <CCol col="">
          <CCardText align="right" id="bio">
            <strong> {{ item.bio }} </strong>
          </CCardText>
        </CCol>
      </CRow>

      <CCRow>
        <CCol>
          <CCardText>
            <strong> {{item.iletisimBilgileri}} </strong>
          </CCardText>
        </CCol>
      </CCRow>

      <CCRow>
        <CCol>
          <CCardText>
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
#id {
  display: block;
  border: 20px solid green;
}
</style>