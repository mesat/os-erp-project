<template>
  <div>
    <div id="selectedTeam">
      <CIcon name="cilStar" id="star">

      </CIcon>
      <EmployeeCard v-for="item in team" :item="item" :key="item.id"></EmployeeCard>

    </div>
    <EmployeeSelect>
      <template #cardActions="{item}">
        <CCol col="12">
          <CButton variant="outline" size="sm" shape="pill" color="success" @click="addToTeam(item.item)">
            Add to team
          </CButton>
        </CCol>
      </template>
    </EmployeeSelect>
  </div>


</template>

<script>
import EmployeeSelect from "../components/EmployeeSelect";
import EmployeeCard from "../components/EmployeeCard";

export default {
  name: "CreateTeam",
  components: {
    EmployeeSelect,
    EmployeeCard
  },
  data () {
    return {
      team: []
    }
  },
  methods: {
    addToTeam(a) {
      this.team.push(a)
    }
  }
}
</script>

<style scoped lang="scss">
#selectedTeam {
  display: flex;
  flex-wrap: wrap;
  background: #ddd;
  border-radius: 10px;
  min-height: 100px;
  padding: 5px;
  margin: 20px 0;
  z-index: 1;
  strong {
    margin: auto;
  }

  .card {
    flex: 0 0 150px;
    margin: 2px;
    height: 280px;
    z-index: 0;
  }
}
#star{
  position: absolute;
  top: 20px;
  width: 30px;
  height: 30px;
  z-index: 2;


}
</style>
