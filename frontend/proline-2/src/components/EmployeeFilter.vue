<template>

  <CCard>
    <CCardHeader>
      <CToggler inHeader="true" @click="toggleFilter">
        <CIcon name="cilList"/>
      </CToggler>
    </CCardHeader>
    <CCollapse :show="filterShow">
      <CCardBody>
        <CRow>
          <CCol>
            <CInput name="name" label="Name" placeholder="enter name"/>
          </CCol>
          <CCol>
            <CInput name="last name" label="Surname" placeholder="enter surname"/>
          </CCol>
          <CRow>
            <CCol>
              <CInput name="telephone" label="Telephone" placeholder="enter phone number"/>
            </CCol>
          </CRow>
          <CRow>
            <CCol>
              <CInput name="date" label="Date" type="date"/>
            </CCol>
            <CCol>
              <CInput name="date" label="..." type="date"/>
            </CCol>
          </CRow>
        </CRow>
      </CCardBody>
      <CCardFooter>
        <CRow>
          <CCol col="10"/>
          <CCol col="2">
            <CButton color="success">
              filter
            </CButton>
          </CCol>
        </CRow>
      </CCardFooter>
    </CCollapse>
  </CCard>
</template>

<script>
export default {
  name: "EmployeeFilter",
  data() {
    return {
      filterShow: true
    }
  },
  methods: {
    toggleFilter() {
      if (this.filterShow) {
        this.filterShow = false
      } else {
        this.filterShow = true
      }
    }
  }
}
</script>

<style scoped>

</style>