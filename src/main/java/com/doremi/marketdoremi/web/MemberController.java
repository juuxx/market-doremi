package com.doremi.marketdoremi.web;

import com.doremi.marketdoremi.service.member.MemberService;
import com.doremi.marketdoremi.web.dto.MemberDataDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public String signup(@RequestBody MemberDataDto memberData) {

        String memberId = memberService.joinUser(memberData);
        log.info("user created::" + memberData.getMember().toString());
        return "redirect:/" + memberId;
    }
}

