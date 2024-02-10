package com.crocusoft.teamprojecttracker.service;

import com.crocusoft.teamprojecttracker.dto.request.TeamRequest;
import com.crocusoft.teamprojecttracker.dto.response.TeamResponse;
import com.crocusoft.teamprojecttracker.mapper.Convert;
import com.crocusoft.teamprojecttracker.model.Team;
import com.crocusoft.teamprojecttracker.model.User;
import com.crocusoft.teamprojecttracker.repository.TeamRepository;
import com.crocusoft.teamprojecttracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final Map<String, Team> teamMap = new HashMap<>();
    private final TeamRepository teamRepository;
    private final Convert convert;
    private final UserRepository userRepository;

    public TeamResponse createTeam(TeamRequest teamRequest) {
        Team newTeam = new Team();
        newTeam.setName(teamRequest.name());
        return convert.teamToTeamResponse(teamRepository.save(newTeam));
    }

    public Map<String, Team> editTeam(String teamName, TeamRequest teamRequest) {
        Team existingTeam = (teamMap.get(teamName) == null) ? teamRepository.findByName(teamName) : teamMap.get(teamName);
        if (existingTeam != null) {
            existingTeam.setName(teamRequest.name());
            teamMap.put(teamRequest.name(), existingTeam);
            teamRepository.save(existingTeam);
            return teamMap;
        } else throw new IllegalArgumentException("No team name found to update");
    }

    public List<User> findUsersByTeamName(String teamName) throws Exception {
        Optional<List<User>> usersInTeamOptional = userRepository.findAllByTeamName(teamName);
        return usersInTeamOptional.orElseThrow(() -> new Exception("No users with team name found"));
    }
}
