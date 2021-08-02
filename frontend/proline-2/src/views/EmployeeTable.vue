<template>
  <div>
    <EmployeeFilter/>
    <div id="employeeContainer">
      <EmployeeCard card :item="emp"/>
      <EmployeeCard card :item="emp"/>
      <EmployeeCard card :item="emp"/>
      <EmployeeCard card :item="emp"/>
      <EmployeeCard card :item="emp"/>
      <EmployeeCard card :item="emp"/>
      <EmployeeCard card :item="emp"/>
    </div>
  </div>
</template>

<script>
import EmployeeCard from "../components/EmployeeCard";
import EmployeeFilter from "../components/EmployeeFilter";
import emp from './_employee';

export default {
  name: "EmployeeTable",
  components: {
    EmployeeCard,
    EmployeeFilter
  },
  data () {
    return {
      emp: emp
    }
  }
}
</script>

<style scoped lang="scss">
#employeeContainer {
  display: flex;
  flex-wrap: wrap;
  background: gray;
  border-radius: 10px;
  .card {
    flex: 0 0 200px;
    margin: 5px;
  }
}

</style>