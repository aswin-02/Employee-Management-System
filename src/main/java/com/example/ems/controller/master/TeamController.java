package com.example.ems.controller.master;

import com.example.ems.model.master.Team;
import com.example.ems.service.master.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master/teams")
@CrossOrigin("*")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("{id}")
    public Optional<Team> getTeamById(@PathVariable Long id){
        return teamService.getTeamById(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team){
        return teamService.saveTeam(team);
    }

    @PutMapping("{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team){
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
    }
}
