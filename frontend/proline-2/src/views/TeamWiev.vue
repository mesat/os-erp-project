<template>
  <div id="teamBoard" v-for="team in teams" :key="team.name">
    <!--
    <h1 style="opacity: 50%" v-if="teamName.match(/^\s*$/)">
      Write a name for the team!
    </h1>
    <h1 v-else>
      {{ teamName }}<span style="opacity: 0">patates</span>
    </h1>-->
    <h1>
      {{ team.name }}
    </h1>
    <div class="selectedTeam">
      <CIcon name="cilStar" class="star" v-if="notEmpty"/>

      <transition-group name="team" id="transitionSpan">
        <EmployeeCard v-for="item in team.members" class="team-item" :item="item" :key="item.id">
          <template #cardActions>
            <div/>
          </template>
        </EmployeeCard>
      </transition-group>
    </div>
  </div>
</template>

<script>
export default {
  name: "TeamWiev"
}
</script>

<style scoped lang="scss">
.ccol {
  justify-content: center;
  display: flex;
}

#teamBoard {
  background: #ddd;
  border-radius: 10px;
  min-height: 350px;
  padding: 10px;
  margin: 20px 0;
  z-index: 0;

  strong {
    margin: auto;

  }

}


.star {
  position: absolute;
  width: 30px;
  height: 30px;
  z-index: 2;
  top: 10px;
  left: 10px;
}

.selectedTeam {
  position: relative;

}

.transitionSpan {
  display: flex;
  width: 100%;
  height: 100%;


  .card {
    flex: 0 0 150px;
    margin: 2px;
    height: 280px;

  }

}

.team-enter-active {

  transition: opacity .3s;
}

.team-leave-active {
  position: absolute;
  transition: opacity .3s;
}

.team-enter, .team-leave-to /* .team-leave-active below version 2.1.8 */
{
  opacity: 0;
}


.team-move {
  transition: transform 0.5s;
}

.team-item {
  transition: all .3s;
  display: inline-block;

}
</style>