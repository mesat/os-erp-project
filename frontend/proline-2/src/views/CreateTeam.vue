<template>
  <div id="name">
    <h1>
      {{ teamName }}
    </h1>
    <!--
    <p v-bind:style="{fontSize:boyut + 'px'}">{{teamName}}</p>
      v-bind
    -->
    <div id="selectedTeam">
      <CIcon name="cilStar" id="star" v-if="notEmpty"/>
      <EmployeeCard v-for="item in team" :item="item" :key="item.id">
        <template #cardActions="{item}">
          <CCol col="8">
            <CButton variant="outline" size="sm" shape="pill" color="warning" @click="makeLeader(item)">
              <nobr>Make Leader</nobr>
            </CButton>
          </CCol>
          <CCol col="4">
            <CButton variant="outline" size="sm" shape="pill" color="danger" @click="remove(item)">
              X
            </CButton>
          </CCol>
        </template>
      </EmployeeCard>
    </div>
    <CRow>
      <CCol>
        <CInput v-model="teamName" placeholder="team name"/>

      </CCol>
      <CCol col = "2">
        <CButton color="warning" v-on:click="clearTeam" v-if="showClear" > Clear Team
        </CButton>
        <!--
          v-on, event handling
          v-if, conditional rendering
        -->

      </CCol>
    </CRow>
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
      team: [],
      teamName: ''
    }
  },
  methods: {
    addToTeam(a) {
      this.team.push(a)
    },
    remove (item) {
      this.team = this.team.filter(function (a) {
        return a.id !== item.id
      })
    },
    makeLeader (item) {
      this.team.remove(item)
      this.team.unshift(item)
    },
    clearTeam() {
      this.team.splice(0,this.team.length)
    }
  },
  computed: {
    notEmpty () {
      return this.team.length !== 0
    },
    showClear () {
      return this.team.length !==0

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
  z-index: 0;
  position: relative;
  strong {
    margin: auto;
  }

  .card {
    flex: 0 0 150px;
    margin: 2px;
    height: 280px;
    z-index: 1;
  }
}
#star{
  position: absolute;
  width: 30px;
  height: 30px;
  z-index: 2;
  top: 10px;
  left: 10px;
}
</style>
