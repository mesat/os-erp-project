<template>
 <div/>
</template>

<script>
import emp from "./_employee";
export default {
  name: "EmployeeView",
  props: ['item'],
  data () {
    return {
      item: emp
    }
  }
}
</script>

<style scoped>

</style>