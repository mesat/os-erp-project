<template>
  <CCard align="left">
    <CCardHeader>
      <img src="../assets/icons/admin.jpg" hegiht="150" width="150">
    </CCardHeader>
    <CCardBody>
      <CRow>
        <CCol>
          <CCardText align="center">
            <h1> AHMET </h1>
          </CCardText>
        </CCol>
      </CRow>
      <CRow>
        <CCol>
          <CCardText align="center">
            <h2>SOYLU</h2>
          </CCardText>
        </CCol>
      </CRow>
      <CRow>
        <CCol>
          <CCardText align="center">
            <h3>CIO</h3>
          </CCardText>
        </CCol>
      </CRow>
    </CCardBody>
    <CCardFooter>
      <CRow>
        <CCol col="-10"/>
        <CCol col="2">
          <CButton color="success">
            Edit
          </CButton>
        </CCol>
        <CCol col="6"/>
        <CCol col="2">
          <CButton color="danger">
            -
          </CButton>
        </CCol>
      </CRow>

    </CCardFooter>
  </CCard>
</template>

<script>
export default {
  name: "EmployeeCard"
}
</script>

<style scoped>

</style>