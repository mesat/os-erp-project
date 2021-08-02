<template>
  <CCard align="left">
    <CCardHeader>
      <img src="../assets/icons/admin.jpg" hegiht="100" width="100">
    </CCardHeader>
    <CCardBody>
      <CRow>
        <CCol>
          <CCardText align="center">
            <h3> {{item.name}} </h3>
          </CCardText>
        </CCol>
      </CRow>
      <CRow>
        <CCol>
          <CCardText align="center">
            <h4>SOYLU</h4>
          </CCardText>
        </CCol>
      </CRow>
      <CRow>
        <CCol>
          <CCardText align="center">
            <strong>CIO</strong>
          </CCardText>
        </CCol>
      </CRow>
    </CCardBody>
    <CCardFooter>
      <CRow>
        <CCol col="-10"/>
        <CCol col="2">
          <CButton variant="outline" size="sm" shape="pill" color="success">
            Edit
          </CButton>
        </CCol>
        <CCol col="6"/>
        <CCol col="2">
          <CButton size="sm" shape="pill" color="danger">
            -
          </CButton>
        </CCol>
      </CRow>

    </CCardFooter>
  </CCard>
</template>

<script>
export default {
  name: "EmployeeCard",
  props: ['item']
}
</script>

<style scoped>

</style>