<template>
  <div>
    <EmployeeFilter/>
    <EmployeeCard/>
  </div>
</template>

<script>
import EmployeeCard from "../components/EmployeeCard";
import EmployeeFilter from "../components/EmployeeFilter";
export default {
  name: "EmployeeTable",
  components: {
    EmployeeCard,
    EmployeeFilter
  }
}
</script>

<style scoped>

</style>