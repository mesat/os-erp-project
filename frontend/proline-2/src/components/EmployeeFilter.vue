<template>


  <CCard>
    <CCardHeader>
      <CRow>
        <CCol col="1">
          <CToggler inHeader @click="toggleFilter">
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
            <CInput v-model="name" name="name" label="Name" placeholder="enter name"/>
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
              <CInput  name="date" label="..." type="date"/>
            </CCol>
          </CRow>
        </CRow>

        <div >
          <span v-for="value in arry">
            <CAlert close-button @update:show="show" color="primary">{{value.filterName}}: {{value.filterValue}}</CAlert>
          </span>


        </div>

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
            <CButton color="success" block @click="filter">
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
      filterShow: false,
      arry: [],
      name:''
    }
  },
  methods: {
    toggleFilter() {
      this.filterShow = !this.filterShow;
    },
    filter() {
      this.arry.push({filterName: 'Name', filterValue: this.name})
    }
  }
}
</script>

<style scoped>

</style>