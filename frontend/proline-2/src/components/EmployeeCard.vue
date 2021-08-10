<template>
  <CCard align="left" id="card">
    <CCardHeader>
      <img src="../assets/icons/admin.jpg" height="100" width="100" alt="profile photo">
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
        <slot name="cardActions" :item="item"></slot>
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
  bottom: 0;
  visibility: hidden;
  opacity: 0;
  transition: visibility 0s, opacity 0.3s;
  width: 100%;
  padding: 10px;
}

#card:hover > #footer {
  opacity: 1;
  visibility: visible;
}


</style>