<template>
  <CCard align="left" id="card">
    <CCardHeader id="header">
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
            <h4>{{item.surName}}</h4>
          </CCardText>
        </CCol>
      </CRow>
      <CRow>
        <CCol>
          <CCardText align="center">
            <strong>{{ item.role }}</strong>
          </CCardText>
        </CCol>
      </CRow>
    </CCardBody>
    <CCardFooter id="footer">
      <CRow>

        <CCol col="2">
          <CButton variant="outline" size="sm" shape="pill" color="success">
            Edit
          </CButton>
        </CCol>
        <CCol col="10"/>
        <!--
        <CCol col="2">
          <CButton size="sm" shape="pill" color="danger">
            -
          </CButton>
        </CCol> -->
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

<style scoped lang="scss">
#footer {
  position: absolute;
  bottom: 0px;
  visibility: hidden;
  opacity: 0;
  transition: visibility 0s, opacity 0.3s;
}

#card:hover > #footer {
  opacity: 1;
  visibility: visible;
}
#header
{
  background-color: teal;
}


</style>