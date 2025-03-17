package com.example.ems.service.master;

import com.example.ems.model.master.Team;
import com.example.ems.repository.master.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id){
        return teamRepository.findById(id);
    }

    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, Team updatedTeam){
        return teamRepository.findById(id)
            .map(team -> {
                team.setName(updatedTeam.getName());
                team.setDescription(updatedTeam.getDescription());
                team.setActive(updatedTeam.getActive());
                team.setDeleted(updatedTeam.getDeleted());
                return teamRepository.save(team);
            })
            .orElseThrow(()->new RuntimeException("Team not found with id: "+id));
    }

    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
    }
}
