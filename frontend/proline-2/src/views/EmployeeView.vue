<template>
  <CCard align="left">
    <CCardHeader>
      <img src="../assets/icons/admin.jpg" hegiht="100" width="100" alt="img">
    </CCardHeader>
    <CCardBody>
      <CRow>
        <CCol>
          <CCardText align="left">
            <h4>Ahmet SOYLU</h4>
          </CCardText>



        </CCol>
      </CRow>
      <CRow>
        <CCol>
          <CCardText align="left">
            <strong>CIO</strong>
          </CCardText>
        </CCol>
      </CRow>
      <CRow>
        <CCol>
          <CCardText align="left">
            <strong>Start Date</strong>
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
  props: ['item'],
  data () {
    return {
      // eslint-disable-next-line vue/no-dupe-keys
      item: emp
    }
  }
}
</script>

<style scoped>

</style>