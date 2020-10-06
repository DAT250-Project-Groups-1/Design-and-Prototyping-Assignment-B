package com.dat250.feedapp.services;

import com.dat250.feedapp.models.IoTDevice;
import com.dat250.feedapp.models.IoTVotes;
import com.dat250.feedapp.models.Poll;
import com.dat250.feedapp.models.PublicVote;
import com.dat250.feedapp.models.User;
import com.dat250.feedapp.models.Vote;
import com.dat250.feedapp.repositories.IoTDeviceDAO;
import com.dat250.feedapp.repositories.IoTVotesDAO;
import com.dat250.feedapp.repositories.PollDAO;
import com.dat250.feedapp.repositories.UserDAO;
import com.dat250.feedapp.repositories.VoteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    @Autowired
    private PollDAO pollDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private VoteDAO voteDAO;

    @Autowired
    private IoTVotesDAO iotVotesDAO;

    @Autowired
    private IoTDeviceDAO ioTDeviceDAO;

    public List<Vote> readAllVotes() {
        return voteDAO.read();
    }

    public Vote readVote(int id) {
        return voteDAO.read(id);
    }

    public boolean addVoteToPoll(Vote vote) {
        User user = userDAO.read(vote.getUser().getId());
        Poll poll = pollDAO.read(vote.getPoll().getId());
        if (user == null || poll == null) {
            return false;
        }
        Vote userHasVoted = user.getVotes().stream().filter(p -> p.getId() == poll.getId()).findAny().orElse(null);
        if (userHasVoted != null) {
            return false;
        }
        if (vote.isYes()) {
            poll.setCountYes(poll.getCountYes() + 1);
        } else {
            poll.setCountNo(poll.getCountNo() + 1);
        }
        vote.setUser(user);
        vote.setPoll(poll);
        voteDAO.create(vote);
        return true;
    }

    public boolean addIoTVotesToPoll(IoTVotes votes) {
        Poll poll = pollDAO.read(votes.getPoll().getId());
        IoTDevice device = ioTDeviceDAO.read(votes.getIoTDevice().getId());
        if (poll == null || device == null) {
            return false;
        }
        poll.setCountYes(poll.getCountYes() + votes.getCountYes());
        poll.setCountNo(poll.getCountNo() + votes.getCountNo());
        votes.setPoll(poll);
        votes.setIoTDevice(device);
        iotVotesDAO.create(votes);
        return true;
    }

    public boolean addPublicVoteToPoll(PublicVote vote) {
        Poll poll = pollDAO.read(vote.getPoll().getId());
        if (poll == null) {
            return false;
        }
        if (vote.isYes()) {
            poll.setCountYes(poll.getCountYes() + 1);
        } else {
            poll.setCountNo(poll.getCountNo() + 1);
        }
        return true;
    }
}
