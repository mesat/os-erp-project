<template>
  <EmployeeSelect>
    <template #cardActions="{item}">
      <CCol col="2">
        <CButton variant="outline" size="sm" shape="pill" color="success" :to="'/view/'+item.item.id">
          View
        </CButton>
      </CCol>
      <CCol col="10"/>
    </template>
  </EmployeeSelect>
</template>
<script>

import EmployeeSelect from "../components/EmployeeSelect";

export default {
  name: "EmployeeTable",
  components: {
    EmployeeSelect
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
  }
}
</script>

<style scoped lang="scss">

</style>