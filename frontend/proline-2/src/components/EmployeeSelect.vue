<template>
  <div>
    <EmployeeFilter id="filter"/>
    <div id="employeeContainer">
      <EmployeeCard v-for="item in emp" :item="item" :key="item.id" card>
        <template #cardActions="item">
          <slot name="cardActions" :item="item"></slot>
        </template>
      </EmployeeCard>
      <strong v-if="empty"> No employees match.</strong>
    </div>
  </div>
</template>
<script>

import EmployeeCard from "./EmployeeCard";
import EmployeeFilter from "./EmployeeFilter";
import emp from '../views/_employee';

export default {
  name: "EmployeeTable",
  components: {
    EmployeeFilter,
    EmployeeCard
  },
  data () {
    return {
      emp: emp
    }
  },
  methods: {

  },
  computed: {
    empty () {
      return this.emp.length === 0
    }
  }
}
</script>

<style scoped lang="scss">
#filter {
  margin: 0
}
#employeeContainer {
  display: flex;
  flex-wrap: wrap;
  background: #ddd;
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  min-height: 100px;
  padding: 5px;
  strong {
    margin: auto;
  }
  .card {
    flex: 0 0 150px;
    margin: 2px;
    height: 280px;
  }
}

</style>