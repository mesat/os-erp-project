<template>

  <CCard>
    <CCardHeader>
      <CToggler inHeader="true" @click="toggleFilter"><CIcon name="cilList" /></CToggler>
    </CCardHeader>
    <CCollapse :show="filterShow">
      lorem ipsum
    </CCollapse>
  </CCard>
</template>

<script>
export default {
  name: "EmployeeFilter",
  data () {
    return {
      filterShow: true
    }
  },
  methods: {
    toggleFilter () {
      if(this.filterShow) {
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