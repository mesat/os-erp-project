<template>
  <div>
    <EmployeeFilter id="filter"/>
    <div id="employeeContainer">
      <CSpinner color="gray-600" v-if="loading" id="spinner"/>
      <div id="emptyText" v-else-if="empty">
        <strong> No employees match.</strong>
      </div>
      <transition-group v-else name="fade" id="transitionSpan">
        <EmployeeCard v-for="item in employees" :item="item" :key="item.id" card>
          <template #cardActions="item">
            <slot name="cardActions" :item="item"></slot>
          </template>
        </EmployeeCard>
      </transition-group>
    </div>
  </div>
</template>
<script>

import EmployeeCard from "./EmployeeCard";
import EmployeeFilter from "./EmployeeFilter";

export default {
  name: "EmployeeTable",
  components: {
    EmployeeFilter,
    EmployeeCard
  },
  props: {
    'emp': {
      type: Array,
      default: () => {
        return []
      }
    },
    'loading': {
      type: Boolean,
      default: false
    },
    'dont': {
      type: Array,
      default: () => {
        return []
      }
    }
  },
  data() {
    return {}
  },
  methods: {},
  computed: {
    empty() {
      return this.emp.length === 0
    },
    employees() {
      return this.emp.filter((a) => {
        return !(this.dont.includes(a.id))
      })
    }
  }
}
</script>

<style scoped lang="scss">
#filter {
  margin: 0
}

#transitionSpan {
  display: flex;
  flex-wrap: wrap;
  width: 100%;
  height: 100%;

  .card {
    flex: 0 0 150px;
    margin: 2px;
    height: 280px;
  }
}

#employeeContainer {
  display: flex;
  background: #ddd;
  position: relative;

  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  min-height: 100px;
  padding: 5px;

  #emptyText {
    display: block;
    width: 100%;
    height: 100%;
    text-align: center;
    strong {

    }
  }
}

#spinner {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  margin: auto;
}

.fade-enter-active {
  transition: opacity .5s;
}

.fade-leave-active {
  position: absolute;
  transition: opacity .5s;
}

.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */
{
  opacity: 0;
}

.fade-move {
  transition: transform 0.5s;
}
</style>