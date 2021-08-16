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
            <CInput v-model="surname" name="last name" label="Surname" placeholder="enter surname"/>
          </CCol>

          <CRow>
            <CCol>
              <CInput v-model="role" name="role" label="Role" placeholder="enter role"/>
            </CCol>
          </CRow>
          <CRow>
            <CCol>
              <CInput v-model="dateStart" name="date" label="Date" type="date"/>
            </CCol>
            <CCol>
              <CInput v-model="dateEnd" name="date" label="..." type="date"/>
            </CCol>
          </CRow>

          <CRow>
            <CCol>
              <CInput v-model="bio" name="bio" label="Bio" placeholder="enter bio"/>
            </CCol>
          </CRow>

        </CRow>

        <div>
          <span v-for="value in filters" :key="value.filterId">
            <CAlert close-button @update:show="show(value)" color="primary">
              {{ value.filterName }}: {{ value.filterValue }}
            </CAlert>
          </span>
        </div>


      </CCardBody>
      <CCardFooter>
        <CRow>
          <CCol col="0" sm="8"/>

          <CCol col="6" sm="2">
            <CButton color="warning" block>
              Clear Filters
            </CButton>
          </CCol>
          <CCol col="6" sm="2">
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
      filters: [],
      name: '',
      surname: '',
      role: '',
      dateStart: '',
      dateEnd: '',
      bio:'',
      i: 0
    }
  },
  methods: {
    toggleFilter() {
      this.filterShow = !this.filterShow;
    },
    filter() {
      this.filters = []
      if (this.name) {
        this.filters.push({filterName: 'Name', filterValue: this.name, filterId: this.i++})
      }
      if (this.surname) {
        this.filters.push({filterName: 'Surname', filterValue: this.surname, filterId: this.i++})
      }
      if(this.role) {
        let words= this.role.split(" ")
        for(let k=0; k < words.length;k++) {
          this.filters.push({filterName: 'Role', filterValue: words[k], filterId: this.i++})
        }
      }
      if(this.dateStart) {
        this.filters.push({filterName: 'DateStart', filterValue: this.dateStart, filterId: this.i++})
      }
      if(this.dateEnd){
        this.filters.push({filterName: 'DateEnd', filterValue: this.dateEnd, filterId: this.i++})
      }
      if(this.bio){
        let words = this.bio.split(" ")
        for(let k=0; k < words.length ;k++) {

          this.filters.push({filterName: 'Bio', filterValue: words[k], filterId: this.i++})

        }
      }
      console.log(this.filters)
    },
    remove (item) {
      this.filters = this.filters.filter(function (a) {
        return a.filterId !== item.filterName
      })
    },
    show(item) {
      this.remove(item)
      console.log(this.filters)
    },

  }
}
</script>

<style scoped>

</style>