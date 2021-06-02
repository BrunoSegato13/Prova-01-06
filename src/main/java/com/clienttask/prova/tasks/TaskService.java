package com.clienttask.prova.tasks;

import com.clienttask.prova.client.Client;
import com.clienttask.prova.client.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ClientService clientService;

    public Task save(Long clientId, Task task){

        Client client = clientService.findById(clientId);

        task.setClient(client);
        task.setStatus(Status.OPEN);
        return taskRepository.save(task);
    }

    public List<Task> findTaskByClient(Long clientId){

        Client client = clientService.findById(clientId);

        List<Task> tasks = taskRepository.findByClient(client);

        return tasks;
    }



}
