<template>
  <div>
    <EmployeeFilter/>
    <div id="employeeContainer">
      <EmployeeCard card/>
      <EmployeeCard card/>
      <EmployeeCard card/>
      <EmployeeCard card/>
      <EmployeeCard card/>
      <EmployeeCard card/>
      <EmployeeCard card/>
    </div>
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

<style scoped lang="scss">
#employeeContainer {
  display: flex;
  flex-wrap: wrap;
  .card {
    flex: 0 0 200px;
    margin: 5px;
  }
}

</style>