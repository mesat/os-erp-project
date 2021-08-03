<template>
  <div>
    <EmployeeFilter/>
    <div id="employeeContainer">
      <EmployeeCard v-for="item in emp" :item="item" :key="item.id" card>
        <template #cardActions="item">
          <slot name="cardActions" :item="item"></slot>
        </template>
      </EmployeeCard>
      <strong v-if="empty"> No employees match.</strong>
    </div>
    <CButton @click="ppp">aaa</CButton>
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
    /*
    'employee-cards': {
      render(createElement) {
        return createElement('div', {
          style: {
            display: 'flex',
            'flex-wrap': 'wrap',
            background: '#ddd',
            'border-radius': '10px'
          }
        }, emp.map(function (a) {
          return createElement('EmployeeCard', {
            props: {
              item: a
            },
            style: {
              margin: '5px',
              flex: '0 0 150px'
            }
          })
        }))
      },
      components: {
        EmployeeCard
      }
    }*/
  },
  data () {
    return {
      emp: emp
    }
  },
  methods: {
    ppp() {
      emp.pop()
    }
  },
  computed: {
    empty () {
      return this.emp.length === 0
    }
  }
}
</script>

<style scoped lang="scss">
#employeeContainer {
  display: flex;
  flex-wrap: wrap;
  background: #ddd;
  border-radius: 10px;
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