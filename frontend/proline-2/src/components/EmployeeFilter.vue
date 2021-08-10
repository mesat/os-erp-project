<template>

  <CCard>
    <CCardHeader>
      <CRow>
        <CCol col="1">
          <CToggler inHeader="true" @click="toggleFilter">
            <CIcon name="cilList"/>
          </CToggler>
        </CCol>
        <Col col="11"/>

      </CRow>

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
              <CInput name="role" label="Role" placeholder="enter role"/>
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
          <CCol col="8"/>

          <CCol col="2">
            <CButton color="warning" block>
              Clear Filters
            </CButton>
          </CCol>
          <CCol col="2">
            <CButton color="success" block>
              Filter
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
      filterShow: false
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