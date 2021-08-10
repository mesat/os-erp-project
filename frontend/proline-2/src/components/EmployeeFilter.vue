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
          <span v-for="value in arry" :key="value.filterId">
            <CAlert close-button @update:show="show(value)" color="primary">
              {{ value.filterName }}: {{ value.filterValue }}:
            </CAlert>
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
      name: '',
      surname: '',
      role: '',
      dateStart: '',
      dateEnd: '',
      bio:''
    }
  },
  methods: {
    toggleFilter() {
      this.filterShow = !this.filterShow;
    },
    filter() {
      this.arry = []
      let i = 0;
      if (this.name) {
        this.arry.push({filterName: 'Name', filterValue: this.name, filterId: i++})
      }
      if (this.surname) {
        this.arry.push({filterName: 'Surname', filterValue: this.surname, filterId: i++})
      }
      if(this.role) {
        this.arry.push({filterName: 'Role', filterValue: this.role, filterId: i++})
      }
      if(this.dateStart) {
        this.arry.push({filterName: 'DateStart', filterValue: this.dateStart, filterId: i++})
      }
      if(this.dateEnd){
        this.arry.push({filterName: 'DateEnd', filterValue: this.dateEnd, filterId: i++})
      }
      if(this.bio){
        let words = this.bio.split(" ")
        for(let k=0; k < words.length ;k++) {

          this.arry.push({filterName: 'Bio', filterValue: words[k], filterId: i++})

        }
      }
    },
    remove (item) {
      this.arry = this.arry.filter(function (a) {
        return a.filterId !== item.filterName
      })
    },
    show(item) {
      this.remove(item)
      console.log(this.arry)
    },

  }
}
</script>

<style scoped>

</style>