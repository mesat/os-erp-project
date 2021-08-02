<template>
 <CCard align="left">
  <CCardHeader>
    <img src="../assets/icons/admin.jpg" hegiht="100" width="100">
  </CCardHeader>

 </CCard>
</template>


<script>
import emp from "./_employee";
export default {
  name: "EmployeeView",
  props: ['itemx'],
  data () {
    return {
      item: {...emp}
    }
  }
}
</script>

<style scoped>

</style>