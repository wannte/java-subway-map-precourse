package subway.question;

import subway.service.MainService;
import subway.service.SectionService;

public enum SectionQuestion implements BaseQuestion {
    REGISTER_STATION("1. 구간 등록", "1") {
        @Override
        public void nextAction() {
            SectionService.register();
            MainService.main();
        }
    },
    DELETE_STATION("2. 구간 삭제", "2") {
        @Override
        public void nextAction() {
            SectionService.delete();
            MainService.main();
        }
    },
    BACK("B. 돌아가기", "B") {
        @Override
        public void nextAction() {
            MainService.main();
        }
    };

    public static final String HEADER = "## 구간 관리 화면";
    private final String option;
    private final String answerCode;

    SectionQuestion(String option, String answerCode) {
        this.option = option;
        this.answerCode = answerCode;
    }

    @Override
    public String getHeader() {
        return HEADER;
    }

    @Override
    public String getOption() {
        return option;
    }

    @Override
    public boolean hasAnswerCode(String inputCode) {
        return this.answerCode.equals(inputCode);
    }
}
